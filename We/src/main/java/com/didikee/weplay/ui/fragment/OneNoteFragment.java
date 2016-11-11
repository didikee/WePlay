package com.didikee.weplay.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didikee.weplay.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OneNoteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OneNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class OneNoteFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_note, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
