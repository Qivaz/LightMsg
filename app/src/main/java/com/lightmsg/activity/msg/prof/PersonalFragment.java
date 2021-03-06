package com.lightmsg.activity.msg.prof;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lightmsg.LightMsg;
import com.lightmsg.R;
import com.lightmsg.activity.msg.LightMsgActivity;
import com.lightmsg.service.CoreService;
import com.lightmsg.service.CoreService.Account;

public class PersonalFragment extends Fragment {

    private static final String TAG = PersonalFragment.class.getSimpleName();
    private LightMsg app = null;
    protected CoreService xs = null;
    private LightMsgActivity activity = null;
    
    private TextView nick;
    private TextView account;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate()...");
        super.onCreate(savedInstanceState);
        activity = (LightMsgActivity)getActivity();
        app = (LightMsg)activity.getApplication();
        xs = app.xs;

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Log.v(TAG, "onCreateView()...");
        View view = inflater.inflate(R.layout.personal, container, false);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.v(TAG, "onActivityCreated()...");
        super.onActivityCreated(savedInstanceState);
        
        View pin = this.getView().findViewById(R.id.personal_info);
        pin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.v(TAG, "onClick(), "+v);
                Intent i = new Intent();
                i.setClass(activity, PersonalInfo.class);
                activity.startActivity(i);
            }
            
        });
        
        Account acc = xs.getAccount();
        if (acc == null) {
            return;
        }
        nick = (TextView) this.getView().findViewById(R.id.nick);
        nick.setText(acc.nick);
        account = (TextView) this.getView().findViewById(R.id.account);
        account.setText(acc.account);
    }

    @Override
    public void onResume() {
        Log.v(TAG, "onResume()...");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v(TAG, "onPause()... ");
        super.onPause();
    }

    @Override
    public void onStart() {
        Log.v(TAG, "onStart()...");
        super.onStart();

    }

    @Override
    public void onStop() {
        Log.v(TAG, "onStop()...");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy()...");
        super.onDestroy();
    }
}
