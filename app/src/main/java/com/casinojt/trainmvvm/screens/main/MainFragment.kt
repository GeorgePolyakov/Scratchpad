package com.casinojt.trainmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.databinding.FragmentMainBinding
import com.casinojt.trainmvvm.utilits.APP_ACTIVITY

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: MainFramentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainFramentViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener{
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}