package com.ankit.chatapp.view.chatRooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ankit.chatapp.databinding.FragmentStartBinding
import com.ankit.chatapp.utils.states.FragmentState
import com.ankit.chatapp.view.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class StartFragment : Fragment() {

    private val firebaseVm: FirebaseViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStartBinding.inflate(LayoutInflater.from(context))
        binding.lifecycleOwner = this
        binding.firebaseVm = firebaseVm
        firebaseVm.setFragmentState(FragmentState.START, false)

        binding.recyclerView.adapter = ChatListAdapter(getOnRoomClickListener())
        firebaseVm.setMsgList(mutableListOf())
        return binding.root
    }

    private fun getOnRoomClickListener(): ChatListAdapter.OnClickListener {
        return ChatListAdapter.OnClickListener { user ->
            firebaseVm.setReceiver(user.user?.value)
            firebaseVm.setFragmentState(FragmentState.CHAT)
        }
    }
}