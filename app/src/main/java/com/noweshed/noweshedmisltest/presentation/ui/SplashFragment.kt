package com.noweshed.noweshedmisltest.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.noweshed.noweshedmisltest.R
import com.noweshed.noweshedmisltest.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashBinding = FragmentSplashBinding.bind(view)

        splashBinding.appLogo.startAnimation(AnimationUtils.loadAnimation(context, R.anim.pulse))

        Handler(Looper.getMainLooper()).postDelayed({
            //navigate to the list fragment
            findNavController().navigate(R.id.action_splashFragment_to_productFragment)
        }, 5000L)
    }
}