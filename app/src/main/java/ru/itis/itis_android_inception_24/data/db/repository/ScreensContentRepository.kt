package ru.itis.itis_android_inception_24.data.db.repository

import android.content.Context
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.model.AnswerModel
import ru.itis.itis_android_inception_24.model.ButtonHolderData
import ru.itis.itis_android_inception_24.model.FirstHolderData
import ru.itis.itis_android_inception_24.model.ListPictureItemModel
import ru.itis.itis_android_inception_24.model.MultipleHoldersData
import ru.itis.itis_android_inception_24.model.QuestionModel
import ru.itis.itis_android_inception_24.model.SecondHolderData
import kotlin.random.Random

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
        ButtonHolderData(
            id = "button_1",
            headerText = "some_text"
        )
    )

    fun getQuestionnaireList(questionsCount: Int): List<QuestionModel> {
        val questionsList = mutableListOf<QuestionModel>()
        val appearedValues = mutableSetOf<Int>()
        repeat(questionsCount) { count ->
            if (appearedValues.size == questions.size) {
                appearedValues.clear()
            }
            val index =
                generateSequence { questions.indices.random() }.first { appearedValues.add(it) }
            questionsList.add(QuestionModel(
                questionId = "question_id_$count",
                questionText = "Кто автор произведения \"${questions[index]}\"",
                answers = mutableListOf<AnswerModel>().also { answersList ->
                    val appeared = mutableSetOf<Int>()
                    repeat(4) {
                        do {
                            val random = Random.nextInt(0, 4)
                        } while (!appeared.add(random))

                    }
                    appeared.forEach {
                        answersList.add(
                            AnswerModel(
                                answerId = "answer_${it}_question_$count",
                                answerText = answers[it]
                            )
                        )
                    }
                    answersList.add(
                        AnswerModel(
                            answerId = "no_correct_id",
                            answerText = "Нет правильного ответа"
                        )
                    )
                }
            ))
        }
        return questionsList
    }

    private val questions = listOf(
        "Мечтают ли андроиды об электроовцах?",
        "Где ты был, Адам?",
        "Умеешь ли ты свистеть, Йоханна?",
        "Что может быть проще времени?",
        "Зачем?",
        "Где ты?",
        "Любите ли вы Брамса?",
        "Сколько стоит человек?",
        "Не все ли равно, что думают другие?",
        "Муля, кого ты привез?"
    )

    private val answers = listOf(
        "Филип Киндред Ди",
        "Генрих Бёлль",
        "Ульф Старк",
        "Клиффорд Саймак",
        "Николай Попов",
        "Марк Леви",
        "Дарио Салас Соммэр",
        "Франсуаза Саган",
        "Ричард Фейнман",
        "Виктория Токарева"
    )

    suspend fun getUserData(): List<String> {
        delay(6000L)
        return listOf("First", "Second", "Third")
    }
}