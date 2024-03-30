package com.example.hw_2_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.hw_2_7.databinding.FragmentStopwatchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopwatchFragment : Fragment() {
    private lateinit var binding:FragmentStopwatchBinding
    private var isRunning = false
    private var seconds = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStopwatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartStop.setOnClickListener {
            if (isRunning){
                stopStopwatch()
            }else{
                startStopwatch()
            }
        }

        binding.btnReset.setOnClickListener {
            resetStopwatch()
        }
    }

    private fun startStopwatch() {
        isRunning = true
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main){
            while (isRunning){
                delay(1000)
                seconds++
                updateUI()
            }
        }
    }

    private fun resetStopwatch(){
        isRunning = false
        seconds = 0
        updateUI()
    }

    private fun updateUI() {
        val hours = seconds / 3600
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        val timeString = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
        binding.tvTime.text = timeString
    }

    private fun stopStopwatch() {
        isRunning = false
    }
}