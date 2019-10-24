package com.wvoz.designsprint

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import androidx.databinding.DataBindingUtil
import com.wvoz.designsprint.databinding.LayoutListBinding

class LogConfirmActivity : WearableActivity() {
    private var mBinding: LayoutListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.layout_list)
        mBinding?.confirmButton?.setOnClickListener { confirm() }
        mBinding?.listTitle = getString(R.string.log_confirm)
        mBinding?.listContent = savedInstanceState?.getString("text") ?: getString(R.string.log_content)



        // Enables Always-on
        setAmbientEnabled()
    }

    private fun confirm() {

        mBinding?.checkbox?.visibility = View.VISIBLE
        mBinding?.checkbox?.animate()
            ?.setDuration(500)
            ?.alpha(1f)
            ?.withEndAction {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
            ?.start()
    }

}
