package com.pdftron.barcode

import com.pdftron.pdf.Annot
import com.pdftron.pdf.PDFViewCtrl
import com.pdftron.pdf.tools.AnnotEdit
import com.pdftron.pdf.tools.QuickMenuItem
import com.pdftron.pdf.utils.Utils

class BarcodeEdit(ctrl: PDFViewCtrl) : AnnotEdit(ctrl) {

    override fun getMenuResByAnnot(annot: Annot?): Int {
        if (!Utils.isNullOrEmpty(annot?.getCustomData(BarcodeCreate.BARCODE_KEY))) {
            return R.menu.annot_barcode
        }
        return super.getMenuResByAnnot(annot)
    }

    override fun onQuickMenuClicked(menuItem: QuickMenuItem?): Boolean {
        if (menuItem?.itemId == R.id.qm_barcode) {
            if (mAnnot != null) {
                val barcode = mAnnot.getCustomData(BarcodeCreate.BARCODE_KEY)
                Utils.safeShowAlertDialog(mPdfViewCtrl.context, barcode, "Content")
            }
            return true
        }
        return super.onQuickMenuClicked(menuItem)
    }

}