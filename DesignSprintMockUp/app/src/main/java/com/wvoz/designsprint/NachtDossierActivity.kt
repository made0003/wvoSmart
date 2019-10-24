package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.databinding.LayoutListBinding

class NachtDossierActivity : WearableActivity() {

    private var mBinding: LayoutListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.layout_list)
        mBinding?.confirmButton?.setOnClickListener { confirm() }
        mBinding?.listTitle = getString(R.string.nacht_dossier_titel)
        mBinding?.listContent = getString(R.string.nacht_dossier)


        // Enables Always-on
        setAmbientEnabled()
    }


    private fun confirm() {

        val i = Intent(this, ChecklistPager::class.java)
        startActivity(i)
    }

}
