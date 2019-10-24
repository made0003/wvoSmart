package com.wvoz.designsprint

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wvoz.designsprint.databinding.ChecklistFragmentBinding

class ChecklistAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mFragments = arrayOfNulls<ChecklistFragment>(4)

    init {

        mFragments[0] = ChecklistFragment.newInstance(
            R.string.checklist_1,
            R.string.checklist_beschrijving_1
        )
        mFragments[1] = ChecklistFragment.newInstance(
            R.string.checklist_2,
            R.string.checklist_beschrijving_2
        )
        mFragments[2] = ChecklistFragment.newInstance(
            R.string.checklist_3,
            R.string.checklist_beschrijving_3
        )
        mFragments[3] = ChecklistFragment.newInstance(finalScreen = true)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position] as Fragment
    }

    override fun getCount(): Int {
        return mFragments.size
    }

}
