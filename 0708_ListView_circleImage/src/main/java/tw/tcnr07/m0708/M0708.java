package tw.tcnr07.m0708;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0708 extends ListActivity {

    private TextView mTxtResult;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource;
    private String[] listFromResource02;
    private TextView ans01,ans02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
//        mTxtResult = (TextView) findViewById(R.id.m0708_t001);
        ans01=(TextView)findViewById(R.id.m0708_t002);
        ans02=(TextView)findViewById(R.id.m0707_descr);
        listFromResource = getResources().getStringArray(R.array.teacname);
        listFromResource02 = getResources().getStringArray(R.array.descr);
//---------------------------------------------------------------
        mList = new ArrayList<>();
        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idName = "t" + String.format("%03d", i);
            int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
            item.put("imgView", resID);  //放圖片，做OPENDATA會用到
            item.put("txtView", listFromResource[i]);  //放陣列文字，做OPENDATA會用到
//            item.put("txtView02", listFromResource02[i]);
            mList.add(item);
        }
            SimpleAdapter adapter = new SimpleAdapter(this, mList, R.layout.list_item,
                    new String[]{"imgView", "txtView"},
                    new int[]{R.id.m0708_im01, R.id.m0708_item_t01});
//        new String[]{"imgView", "txtView","txtView02"},
//        new int[]{R.id.m0708_im01, R.id.m0708_item_t01,R.id.m0708_item_t02});
            //----------------------------------------------------------------
        //----------------------------------------------------------------

            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);
        }
        AdapterView.OnItemClickListener listviewOnItemClkLis= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mTxtResult.setText(getString(R.string.m0708_t001)+listFromResource[position]);
                ans01.setText(getString(R.string.m0708_t002)+listFromResource[position]);
                ans02.setText(getString(R.string.m0708_descr)+listFromResource02[position]);
            }
        };
}