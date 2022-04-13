package com.casinojt.trainmvvm.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.databinding.FragmentStartBinding
import com.casinojt.trainmvvm.utilits.APP_ACTIVITY
import com.casinojt.trainmvvm.utilits.TYPE_ROOM

class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: StartFragmentViewModel
    private var btn_room: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //var view = inflater.inflate(R.layout.fragment_start,container,false)
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        binding?.btnRoom?.setOnClickListener {
            mViewModel.initDataBase(TYPE_ROOM){
                APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}