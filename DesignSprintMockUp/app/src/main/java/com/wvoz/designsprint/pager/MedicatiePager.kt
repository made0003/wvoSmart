package com.wvoz.designsprint.pager

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.wvoz.designsprint.R
import com.wvoz.designsprint.adapter.MedicatieAdapter
import com.wvoz.designsprint.databinding.PagerLayoutBinding

class MedicatiePager : FragmentActivity() {

    private var mBinding: PagerLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.pager_layout)
        mBinding?.pager?.adapter =
            MedicatieAdapter(supportFragmentManager)
     }

}
