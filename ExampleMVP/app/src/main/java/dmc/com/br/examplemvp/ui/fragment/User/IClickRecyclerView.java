package dmc.com.br.examplemvp.ui.fragment.User;

/**
 * Created by diogo on 20/10/2017.
 */

interface IClickRecyclerView<T> {
    void onClickItem(T type);

    void onClickEdit(T type);

    void onClickDelete(T type);
}
