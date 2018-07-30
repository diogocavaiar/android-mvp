package dmc.com.br.examplemvp.ui.fragment.User;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.data.model.User;

/**
 * Created by diogo on 16/10/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements UserFilter.FiltroCallback, Filterable {

    private final IClickRecyclerView mListener;
    private List<User> mUserList;

    private UserFilter filtro;

    private static final int VIEW_TYPE_DATA = 0;
    private static final int VIEW_TYPE_EMPTY_STATE = 1;

    public UserAdapter(final List<User> user, IClickRecyclerView listener) {
        mUserList = user;
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return mUserList.isEmpty() ? VIEW_TYPE_EMPTY_STATE : VIEW_TYPE_DATA;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        if(viewType == VIEW_TYPE_DATA) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_one, parent, false);
            viewHolder = new UserViewHolder(view, mListener);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_empty, parent, false);
            viewHolder = new UserEmptyStateViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof UserViewHolder) {
            User user = mUserList.get(position);
            ((UserViewHolder) viewHolder).bind(user);
        }
    }

    @Override
    public int getItemCount() {
        return mUserList.isEmpty() ? 1 : mUserList.size();
    }

    private User getUser(final int position) {
        return mUserList.get(position);
    }

    public void replaceData(User user) {
        mUserList.add(user);
        notifyDataSetChanged();
    }

    public void setList(List<User> users) {
        mUserList = users;
    }

    public void removeUser(User user) {
        if(user != null) {
            if(mUserList.contains(user)) {
                mUserList.remove(user);
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public Filter getFilter() {
        if (filtro == null) {
            filtro = new UserFilter(mUserList, this);
        }
        return filtro;
    }

    @Override
    public void carregarResultados(final List<User> lista) {
        mUserList = lista;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mFirstName;
        public TextView mLastName;
        public TextView mEmail;
        public ImageButton mEdit;
        public ImageButton mDelete;

        private final IClickRecyclerView mListenerHolder;

        public UserViewHolder(View itemView, IClickRecyclerView listener) {
            super(itemView);
            mListenerHolder = listener;

            mFirstName = (TextView) itemView.findViewById(R.id.tvFirstName);
            mLastName = (TextView) itemView.findViewById(R.id.tvLastName);
            mEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mEdit = (ImageButton) itemView.findViewById(R.id.btEdit);
            mDelete = (ImageButton) itemView.findViewById(R.id.btDelete);

            mEdit.setOnClickListener(this);
            mDelete.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        public void bind(User user) {
            mFirstName.setText(user.getFirstName());
            mLastName.setText(user.getLastName());
            mEmail.setText(user.getEmail());
        }

        @Override
        public void onClick(View v) {
            if(mListenerHolder != null) {
                switch (v.getId()) {
                    case R.id.btEdit:
                        mListenerHolder.onClickEdit(getUser(getAdapterPosition()));
                        break;
                    case R.id.btDelete:
                        mListenerHolder.onClickDelete(getUser(getAdapterPosition()));
                        break;
                    default:
                        mListenerHolder.onClickItem(getUser(getAdapterPosition()));
                        break;
                }
            }
        }
    }

    static class UserEmptyStateViewHolder extends RecyclerView.ViewHolder {
        public UserEmptyStateViewHolder(View itemView) {
            super(itemView);
        }
    }
}
