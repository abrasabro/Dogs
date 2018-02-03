package t.test.dogs;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Owner on 2/2/2018.
 */

public class TypesAdapter extends RecyclerView.Adapter<TypesAdapter.TypeViewHolder>{

    private List<String> mTypes;
    private int mRowLayout;
    private Context mContext;

    public TypesAdapter(List<String> types, int rowLayout, Context context) {
        mTypes = types;
        mRowLayout = rowLayout;
        mContext = context;
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "TypeViewHolder";
        TextView mBreed;
        public TypeViewHolder(View view) {
            super(view);
            mBreed = view.findViewById(R.id.textView_type);
            mBreed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: called");
                    ((MainActivity) mContext).changeFragment(R.layout.fragment_breed, mBreed.getText().toString());
                }
            });
        }
    }

    @Override
    public TypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TypeViewHolder holder, int position) {
        holder.mBreed.setText(mTypes.get(position));
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }


}
