package com.casinojt.trainmvvm.screens.note

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.databinding.FragmentMainBinding
import com.casinojt.trainmvvm.databinding.FragmentNoteBinding
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.screens.main.MainAdapter
import com.casinojt.trainmvvm.screens.main.MainFramentViewModel
import com.casinojt.trainmvvm.utilits.APP_ACTIVITY

class NoteFragment : Fragment() {

    private var binding: FragmentNoteBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: NoteFragmentViewModel
    private lateinit var currentNote:AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentNote = arguments?.getSerializable("note") as AppNote
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        setHasOptionsMenu(true)
        mBinding.noteText.text = currentNote.text
        mBinding.noteName.text = currentNote.name
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.note_action_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_delete ->{
                Log.d("buttoncheck", "the button was called")
                mViewModel.delete(currentNote){
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }

}