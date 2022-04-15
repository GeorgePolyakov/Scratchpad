package com.casinojt.trainmvvm.screens.add_new_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.databinding.FragmentAddNewNoteBinding
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.utilits.APP_ACTIVITY
import com.casinojt.trainmvvm.utilits.showToast

class AddNewNoteFragment : Fragment() {

    private var binding:FragmentAddNewNoteBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: AddNewNoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewNoteBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
      mViewModel = ViewModelProvider(this).get(AddNewNoteFragmentViewModel::class.java)
      mBinding.btnAddNote.setOnClickListener{
          val name = mBinding.inputNameNote.text.toString()
          val text = mBinding.inputTextNote.text.toString()
          val navigate = {APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)}
          if(name.isEmpty()){
                showToast(getString(R.string.toast_entered_name))
          } else {
              mViewModel.insert(AppNote(name = name, text = text),navigate)
          }
      }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}