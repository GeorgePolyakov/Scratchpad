package com.casinojt.trainmvvm.screens.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.casinojt.trainmvvm.R
import com.casinojt.trainmvvm.databinding.FragmentMainBinding
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.utilits.APP_ACTIVITY

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: MainFramentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<AppNote>>

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
        setHasOptionsMenu(true)
        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainFramentViewModel::class.java)
        mViewModel.allNotes.observe(viewLifecycleOwner, mObserverList)
        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        mRecyclerView.adapter = null

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_action_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_exit -> {
                Log.d("buttoncheck", "the button was called")
                mViewModel.signOut()
                APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_startFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }

}