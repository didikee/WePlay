package com.didikee.weplay.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.didikee.uilibs.utils.DisplayUtil;
import com.didikee.weplay.R;
import com.didikee.weplay.base.APPCode;
import com.didikee.weplay.base.BaseFragment;
import com.didikee.weplay.base.BaseRVViewHolder;
import com.didikee.weplay.base.SimpleRVAdapter;
import com.didikee.weplay.custom.utils.RVItemDecoration;
import com.didikee.weplay.framework.AsyncContactHandler;
import com.didikee.weplay.framework.db.DBManager;
import com.didikee.weplay.framework.db.bean.Person;
import com.didikee.weplay.framework.db.bean.SimpleContact;
import com.didikee.weplay.ui.views.FavoriteHumanLayout;
import com.didikee.weplay.ui.views.iview.OnFavoriteHumanClickListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by didik on 2016/11/22.
 */

public class FavoriteFragment extends BaseFragment implements OnFavoriteHumanClickListener {

    private RecyclerView mRV;
    private FavoriteHumanLayout mFavoriteHumanLayout;
    private final String TAG= getClass().getSimpleName();
    private SimpleRVAdapter<Person> favoriteAdapter;

    @Override
    protected int setLayoutResId() {
        return R.layout.frag_favorite;
    }

    @Override
    protected void initView() {
        mRV = ((RecyclerView) content.findViewById(R.id.recyclerView));
        mFavoriteHumanLayout = ((FavoriteHumanLayout) content.findViewById(R.id.favorite_layout));
    }

    @Override
    protected void startFlow() {
        mFavoriteHumanLayout.setOnFavoriteHumanClickListener(this);
        ArrayList<String> data=new ArrayList<>();
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        favoriteAdapter = new SimpleRVAdapter<Person>(getContext(), R.layout.rv_item_favorite) {
            @Override
            protected void bindView(BaseRVViewHolder helper, Person item) {
                helper.setTextView(R.id.tv_name,item.getName());
                helper.setTextView(R.id.tv_phone,item.getPhones());
            }
        };
        mRV.setHasFixedSize(true);
        mRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRV.addItemDecoration(new RVItemDecoration(RVItemDecoration.VERTICAL, DisplayUtil.dp2px(getContext(),1.5f)));
//        favoriteAdapter.setData(data);
        mRV.setAdapter(favoriteAdapter);
    }

    @Override
    public void onNoteClick(View view, Long number) {
        DBManager.getPersonDaoHelper().deleteAll();
        getContacts();

    }

    @Override
    public void onLikeClick(View view, Long number) {
        List<Person> allPersons = DBManager.getPersonDaoHelper().queryAll();
        for (Person allPerson : allPersons) {
            Log.d("person","name: "+allPerson.getName() +" phone:"+allPerson.getPhones()+" email: "+allPerson.getEmails()+"\n");
        }
        favoriteAdapter.setData(allPersons);
    }

    @Override
    public void onSadClick(View view, Long number) {

    }


    private void getContacts(){
        AsyncContactHandler handler=new AsyncContactHandler(getContext()){
            @Override
            protected void onPostExecute(List<SimpleContact> simpleContacts) {
                super.onPostExecute(simpleContacts);
                doContacts(simpleContacts);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                Log.d(TAG,"ProgressUpdate: "+values[0]);
            }
        };
        handler.execute();
    }

    private void doContacts(List<SimpleContact> simpleContacts) {
        if (simpleContacts == null || simpleContacts.size()<1) return;
        List<Person> personList=new ArrayList<>();
        for (SimpleContact simpleContact : simpleContacts) {
            Person single=new Person();
            String name = simpleContact.getName();
            if (TextUtils.isEmpty(name)){
                continue;
            }
            single.setName(name);

            String emails="";
            List<String> email = simpleContact.getEmail();
            if (email !=null && email.size()>0){
                for (int i = 0; i < email.size(); i++) {
                    emails= emails+ email.get(i)+ APPCode.SEPARATE;
                }
            }
            single.setEmails(emails);

            String phones="";
            List<String> phone = simpleContact.getPhone();
            if (phone !=null && phone.size()>0){
                for (int i = 0; i < phone.size(); i++) {
                    phones= phones+ phone.get(i)+ APPCode.SEPARATE;
                }
            }
            single.setPhones(phones);
            personList.add(single);
        }
        DBManager.getPersonDaoHelper().save(personList);
    }
}
