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
import com.casinojt.trainmvvm.utilits.*

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
            mViewModel.initDataBase(TYPE_ROOM) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment) // chose Db type ROOM and navigate to MainFragment
            }
        }
        mBinding.btnFirebase.setOnClickListener {
            mBinding.inputPassword.visibility = View.VISIBLE
            mBinding.inputEmail.visibility = View.VISIBLE
            mBinding.btnLogin.visibility = View.VISIBLE
            mBinding.btnLogin.setOnClickListener {
                val inputEmail = mBinding.inputEmail.text.toString()
                val inputPassword = mBinding.inputPassword.text.toString()
                if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSSWORD = inputPassword
                    mViewModel.initDataBase(TYPE_FIREBASE) {
                        showToast("INIT OK")
                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment) // chose Db type Firebase and navigate to MainFragment
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_answer))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}