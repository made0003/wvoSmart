package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.databinding.LayoutListBinding

class AgendaActivity : WearableActivity() {
        private var mBinding: LayoutListBinding? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mBinding = DataBindingUtil.setContentView(this, R.layout.layout_list)
            mBinding?.confirmButton?.setOnClickListener { confirm() }
            mBinding?.listTitle = getString(R.string.agenda_titel)
            mBinding?.listContent = getString(R.string.agenda_items)


            // Enables Always-on
            setAmbientEnabled()
        }


        private fun confirm() {

            val i = Intent(this, DossierActivity::class.java)
            startActivity(i)
            finish()
        }

    }
