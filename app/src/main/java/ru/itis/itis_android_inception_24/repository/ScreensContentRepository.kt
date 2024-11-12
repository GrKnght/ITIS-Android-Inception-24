package ru.itis.itis_android_inception_24.repository

import android.content.Context
import androidx.core.content.ContextCompat
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.model.FirstHolderData
import ru.itis.itis_android_inception_24.model.ListPictureItemModel
import ru.itis.itis_android_inception_24.model.MultipleHoldersData
import ru.itis.itis_android_inception_24.model.SecondHolderData

object ScreensContentRepository {

    fun getListContentScreenInitialData(ctx: Context): List<ListPictureItemModel> = listOf(
        ListPictureItemModel(
            imageUrl = "https://images.squarespace-cdn.com/content/v1/54822a56e4b0b30bd821480c/45ed8ecf-0bb2-4e34-8fcf-624db47c43c8/Golden+Retrievers+dans+pet+care.jpeg",
            description = "first dog",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://lumiere-a.akamaihd.net/v1/images/open-uri20160811-32147-ybg65r_0a6d1a69.jpeg?region=0,0,640,360",
            description = "second car",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_500)
        ),
        ListPictureItemModel(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4mB6qxKTqeJ5H08DhnjbJybh_WUXq40LPiw&s",
            description = "third cat",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
            description = "android logo",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
            description = "ochopchmak",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://images.squarespace-cdn.com/content/v1/54822a56e4b0b30bd821480c/45ed8ecf-0bb2-4e34-8fcf-624db47c43c8/Golden+Retrievers+dans+pet+care.jpeg",
            description = "first dog",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://lumiere-a.akamaihd.net/v1/images/open-uri20160811-32147-ybg65r_0a6d1a69.jpeg?region=0,0,640,360",
            description = "second car",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_500)
        ),
        ListPictureItemModel(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4mB6qxKTqeJ5H08DhnjbJybh_WUXq40LPiw&s",
            description = "third cat",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
            description = "android logo",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
            description = "ochopchmak",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://images.squarespace-cdn.com/content/v1/54822a56e4b0b30bd821480c/45ed8ecf-0bb2-4e34-8fcf-624db47c43c8/Golden+Retrievers+dans+pet+care.jpeg",
            description = "first dog",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://lumiere-a.akamaihd.net/v1/images/open-uri20160811-32147-ybg65r_0a6d1a69.jpeg?region=0,0,640,360",
            description = "second car",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_500)
        ),
        ListPictureItemModel(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4mB6qxKTqeJ5H08DhnjbJybh_WUXq40LPiw&s",
            description = "third cat",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
            description = "android logo",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
            description = "ochopchmak",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://images.squarespace-cdn.com/content/v1/54822a56e4b0b30bd821480c/45ed8ecf-0bb2-4e34-8fcf-624db47c43c8/Golden+Retrievers+dans+pet+care.jpeg",
            description = "first dog",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://lumiere-a.akamaihd.net/v1/images/open-uri20160811-32147-ybg65r_0a6d1a69.jpeg?region=0,0,640,360",
            description = "second car",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_500)
        ),
        ListPictureItemModel(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4mB6qxKTqeJ5H08DhnjbJybh_WUXq40LPiw&s",
            description = "third cat",
            backgroundColor = ContextCompat.getColor(ctx, R.color.purple_700)
        ),
        ListPictureItemModel(
            imageUrl = "https://dwglogo.com/wp-content/uploads/2019/09/1400px-Android_logo_2019.png",
            description = "android logo",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_200)
        ),
        ListPictureItemModel(
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
            description = "ochopchmak",
            backgroundColor = ContextCompat.getColor(ctx, R.color.teal_700)
        )
    )

    fun getListForMultipleTypes(): List<MultipleHoldersData> = listOf(
        FirstHolderData(
            id = "first_id",
            headerText = "Some header cat",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4mB6qxKTqeJ5H08DhnjbJybh_WUXq40LPiw&s"
        ),
        SecondHolderData(
            id = "second_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
        SecondHolderData(
            id = "third_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
        SecondHolderData(
            id = "fourth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
        SecondHolderData(
            id = "fifth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
        FirstHolderData(
            id = "last_elem_id",
            headerText = "Some footer dog",
            imageUrl = "https://images.squarespace-cdn.com/content/v1/54822a56e4b0b30bd821480c/45ed8ecf-0bb2-4e34-8fcf-624db47c43c8/Golden+Retrievers+dans+pet+care.jpeg"
        ),
        SecondHolderData(
            id = "fourth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
        SecondHolderData(
            id = "fifth_id",
            headerText = "Hello from elem",
            descText = "some description text to sample",
            imageUrl = "https://www.tatarpirog.ru/i_all/shop/shop_large_15.jpg",
        ),
    )
}