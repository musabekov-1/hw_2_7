package com.example.hw_2_7

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class Adapter(fragment:FragmentActivity):FragmentStateAdapter(fragment){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> StopwatchFragment()
            1 -> TimerFragment()
            else -> {AlarmClockFragment()}
        }
    }
}