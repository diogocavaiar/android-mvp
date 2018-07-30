package dmc.com.br.examplemvp.ui.fragment.User;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import dmc.com.br.examplemvp.data.model.User;

public class UserFilter extends Filter {

    private final List<User> listaOriginal;
    private final FiltroCallback filtroCallback;

    public interface FiltroCallback {
        void carregarResultados(List<User> lista);
    }

    public UserFilter(final List<User> listaOriginal, final FiltroCallback filtroCallback) {
        this.listaOriginal = listaOriginal;
        this.filtroCallback = filtroCallback;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        List<User> listaFiltrada = new ArrayList<>();

        if (constraint.length() <= 0) {
            listaFiltrada = listaOriginal;
        } else {
            for (User user : listaOriginal) {
                if (user.getFirstName().toLowerCase()
                        .contains(constraint.toString().toLowerCase())) {
                    listaFiltrada.add(user);
                }
            }
        }

        FilterResults filterResults = new FilterResults();
        filterResults.values = listaFiltrada;

        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        filtroCallback.carregarResultados((List<User>) results.values);
    }
}
