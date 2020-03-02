package com.ferdyrod.viewpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(
    activity: FragmentActivity,
    private val size: SIZE
): FragmentStateAdapter(activity) {

    override fun getItemCount() = when (size) {
        SIZE.THREE -> 3
        SIZE.FOUR -> 4
    }

    override fun createFragment(position: Int): Fragment {
        return if (size == SIZE.THREE) {
            when (position) {
                0 -> FragmentB()
                1 -> FragmentC()
                2 -> FragmentD()
                else -> throw IllegalArgumentException()
            }
        } else {
            when (position) {
                0 -> FragmentA()
                1 -> FragmentB()
                2 -> FragmentC()
                3 -> FragmentD()
                else -> throw IllegalArgumentException()
            }
        }
    }
}

enum class SIZE {
    THREE,
    FOUR
}