package com.scripts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment {

    ListView list;
    InterfaceForFragments interfaceForFragments;
    ListAdapterCrypto adapter;
    boolean isAdapterCreated = false;

    public MoneyFragment() {
        // Required empty public constructor
    }

    public  void setInterfaceForFragments(InterfaceForFragments interfaceForFragments) {
        this.interfaceForFragments = interfaceForFragments;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_money, container, false);
        list = (ListView) view.findViewById(R.id.listView);
        makeTheList();

        PublicStuff.setCurrentFragment(PublicStuff.fragmentType.MONEY);

        setInterfaceForFragments(interfaceForFragments);
        return view;
    }


    private void makeTheList() {
        if(!isAdapterCreated) {adapter = new ListAdapterCrypto(this, PublicStuff.getMoney()); isAdapterCreated = true;}
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(interfaceForFragments!=null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("KEY_POSITION", i);
                    bundle.putString("KEY_MODE", "ListClick");

                    interfaceForFragments.onActionInFragment(bundle);
                }

                //Intent intent = new Intent(getActivity(), currency_everything.class);
            //intent.putExtra("kelintas", i);
            //startActivity(intent);
         }
        });
    }

}
