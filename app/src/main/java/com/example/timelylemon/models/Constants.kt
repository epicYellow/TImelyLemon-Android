package com.example.timelylemon.models

import com.example.timelylemon.R

//https://boomagain.com/70s-trivia/
//https://groupgames101.com/90s-trivia-questions/
//https://groupgames101.com/80s-trivia-questions-and-answers/

object Constants {

    val LAST_USER: String = "username"
    val LAST_SCORE: String = "lastscore"
    val CAT_ONE_SCORE: String = "catonescore"
    val CAT_TWO_SCORE: String = "cattwoscore"
    val CAT_THREE_SCORE: String = "cathreescore"

    fun getAll70sQuestions() : ArrayList<Question> {
        var all70sQuestions = ArrayList<Question>()

        //Data
        val questionOne = Question(
            id = 1,
            questionTxt = "Who were the top two stars of the 1976 hit film “The Bad News Bears?",
            img = R.drawable.cat_one_one,
            bg = R.drawable.bg_android_sev,
            rb = R.drawable.img_cat_sev_ques,
            optionOne = "Farrah Fawcett and Lee Majors",
            optionTwo = "Harrison Ford and Raquel Welch",
            optionThree = "Raquel Welch and Joe Namath",
            optionFour = "Walter Matthau and Tatum O’Neal"
        )

        val questionTwo = Question(
            id = 2,
            questionTxt = "Starting in 1970, a cheerful bright yellow symbol started showing up on buttons, mugs, and t-shirts. What was the four-word expression often depicted with this smiling image?",
            img = R.drawable.cat_one_two,
            bg = R.drawable.bg_android_sev,
            rb = R.drawable.img_cat_sev_ques,
            optionOne = "Time to cheer up",
            optionTwo = "Have a Nice Day",
            optionThree = "Share a smile today",
            optionFour = "A great yellow smile"
        )

        val questionThree = Question(
            id = 3,
            questionTxt = "In 1974, “People Magazine” covered the May-December relationship between the star of “Cannonball Run” and an older daytime talk show host. Who were they?",
            img = R.drawable.cat_one_three,
            bg = R.drawable.bg_android_sev,
            rb = R.drawable.img_cat_sev_ques,
            optionOne = "Bianca Jagger",
            optionTwo = "Burt Reynolds and Dinah Shore",
            optionThree = "Farrah Fawcett and Dean Martin",
            optionFour = "Adrienne Barbeau and Terry Bradshaw"
        )

        val questionFour = Question(
            id = 4,
            questionTxt = "Why did Procter & Gamble replace the “mom” on the cover of the Ivory soapbox in 1972?",
            img = R.drawable.cat_one_four,
            bg = R.drawable.bg_android_sev,
            rb = R.drawable.img_cat_sev_ques,
            optionOne = "The model was Marilyn Chambers, a porn star",
            optionTwo = "Legal issues regarding the rights to the photo",
            optionThree = "She was not pretty enough",
            optionFour = "She did not match the company slogan"
        )

        val questionFive = Question(
            id = 5,
            questionTxt = "In the 1970s, Woodsy Owl used what motto in his public service announcements about pollution?",
            img = R.drawable.cat_one_five,
            bg = R.drawable.bg_android_sev,
            rb = R.drawable.img_cat_sev_ques,
            optionOne = "Woooo lighted that fire?",
            optionTwo = "Save the Earth, save yourselves",
            optionThree = "Give a hoot, don’t pollute",
            optionFour = "Love to breathe, save the trees"
        )

        all70sQuestions.add(questionOne)
        all70sQuestions.add(questionTwo)
        all70sQuestions.add(questionThree)
        all70sQuestions.add(questionFour)
        all70sQuestions.add(questionFive)

        return all70sQuestions;
    }

    fun getAll80sQuestions() : ArrayList<Question> {
        var all80sQuestions = ArrayList<Question>()

        //Data
        val questionOne = Question(
            id = 1,
            questionTxt = "Where were the 1980 Olympic Games held?",
            img = R.drawable.cat_two_one,
            bg = R.drawable.bg_android_eight,
            rb = R.drawable.img_cat_eight_ques,
            optionOne = "Paris",
            optionTwo = "Atlanta",
            optionThree = "Moscow",
            optionFour = "Montreal"
        )

        val questionTwo = Question(
            id = 2,
            questionTxt = "What does VHS stand for?",
            img = R.drawable.cat_two_two,
            bg = R.drawable.bg_android_eight,
            rb = R.drawable.img_cat_eight_ques,
            optionOne = "Visual Housing System",
            optionTwo = "Video Home System",
            optionThree = "Video Housing System",
            optionFour = "Visual Handling System"
        )

        val questionThree = Question(
            id = 3,
            questionTxt = "Which advertising slogan was launched by Nike in 1988?",
            img = R.drawable.cat_two_three,
            bg = R.drawable.bg_android_eight,
            rb = R.drawable.img_cat_eight_ques,
            optionOne = "Greatness is not born, it is made.",
            optionTwo = "Just Do It",
            optionThree = "Be legendary.",
            optionFour = "Run the day. Don’t let it run you."
        )

        val questionFour = Question(
            id = 4,
            questionTxt = "What photographic device was introduced to the world in 1986?",
            img = R.drawable.cat_two_four,
            bg = R.drawable.bg_android_eight,
            rb = R.drawable.img_cat_eight_ques,
            optionOne = "The Fuji QuickSnap",
            optionTwo = "Kodak Ekralite",
            optionThree = "Canon T80",
            optionFour = "CONTAX AX"
        )

        val questionFive = Question(
            id = 5,
            questionTxt = "What was the name of the space shuttle that tragically exploded in 1986?",
            img = R.drawable.cat_two_five,
            bg = R.drawable.bg_android_eight,
            rb = R.drawable.img_cat_eight_ques,
            optionOne = "Discovery",
            optionTwo = "Columbia",
            optionThree = "Enterprise",
            optionFour = "Challenger"
        )

        all80sQuestions.add(questionOne)
        all80sQuestions.add(questionTwo)
        all80sQuestions.add(questionThree)
        all80sQuestions.add(questionFour)
        all80sQuestions.add(questionFive)

        return all80sQuestions;
    }
    fun getAll90sQuestions() : ArrayList<Question> {
        var all90sQuestions = ArrayList<Question>()

        //Data
        val questionOne = Question(
            id = 1,
            questionTxt = "Which was the first video game played in space in the 1990's?",
            img = R.drawable.cat_three_one,
            bg = R.drawable.bg_android_nine,
            rb = R.drawable.img_cat_nine_ques,
            optionOne = "Pac-Man",
            optionTwo = "Tetris",
            optionThree = "Super Mario World",
            optionFour = "Mega Man 3"
        )

        val questionTwo = Question(
            id = 2,
            questionTxt = "Which legendary Mall opened in 1992?",
            img = R.drawable.cat_three_two,
            bg = R.drawable.bg_android_nine,
            rb = R.drawable.img_cat_nine_ques,
            optionOne = "Cascade Mall",
            optionTwo = "Mall of Africa",
            optionThree = "The Mall of America",
            optionFour = "Crystal River Mall"
        )

        val questionThree = Question(
            id = 3,
            questionTxt = "Which website was first introduced in 1998?",
            img = R.drawable.cat_three_three,
            bg = R.drawable.bg_android_nine,
            rb = R.drawable.img_cat_nine_ques,
            optionOne = "Google",
            optionTwo = "Hampster Dance",
            optionThree = "Space Jam",
            optionFour = "CNN"
        )

        val questionFour = Question(
            id = 4,
            questionTxt = "What was the most best-selling console?",
            img = R.drawable.cat_three_four,
            bg = R.drawable.bg_android_nine,
            rb = R.drawable.img_cat_nine_ques,
            optionOne = "Sony Playstation",
            optionTwo = "Nintendo 64",
            optionThree = "Super Nintendo",
            optionFour = "Game Boy Color"
        )

        val questionFive = Question(
            id = 5,
            questionTxt = "In the 1990’s, scientists managed to clone a sheep. What was the sheep’s name?",
            img = R.drawable.cat_three_five,
            bg = R.drawable.bg_android_nine,
            rb = R.drawable.img_cat_nine_ques,
            optionOne = "Steve",
            optionTwo = "Shaun",
            optionThree = "Jeff",
            optionFour = "Dolly"
        )

        all90sQuestions.add(questionOne)
        all90sQuestions.add(questionTwo)
        all90sQuestions.add(questionThree)
        all90sQuestions.add(questionFour)
        all90sQuestions.add(questionFive)

        return all90sQuestions;
    }

}