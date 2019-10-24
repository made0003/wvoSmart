package com.wvoz.designsprint

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.wvoz.designsprint.databinding.MedicatiePagerBinding

class MedicatiePager : FragmentActivity() {

    private var mBinding: MedicatiePagerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.medicatie_pager)
        mBinding?.medicatiePager?.adapter = MedicatieAdapter(supportFragmentManager)
     }

}
