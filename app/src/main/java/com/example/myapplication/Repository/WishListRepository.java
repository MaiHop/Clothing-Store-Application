    package com.example.myapplication.Repository;

    import com.example.myapplication.Api.KhachHang_api;
    import com.example.myapplication.Api.SanPham_api;
    import com.example.myapplication.Api.ServiceBuilder;
    import com.example.myapplication.Model2.SanPham;

    import java.util.List;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;

    public class WishListRepository {

        WishListInterface wishListInterface;

        public WishListRepository(WishListInterface wishListInterface){
            this.wishListInterface = wishListInterface;
        }

        public void readWishList(){
            SanPham_api sanPham_api = ServiceBuilder.buildService(SanPham_api.class);
            Call<List<SanPham>> request = sanPham_api.readallSanPham();
            request.enqueue(new Callback<List<SanPham>>() {
                @Override
                public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                    if (response.isSuccessful()){
                        wishListInterface.getWishList(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<SanPham>> call, Throwable t) {

                }
            });
        }




        public interface WishListInterface{
            void getWishList(List<SanPham> list_sp_wishlist);
        }
    }
