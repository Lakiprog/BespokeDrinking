import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState } from "react";
import { Question } from "../../Model/Question";
import { User } from "../../Model/User";
import axios from "axios";
import {
	GET_ONE_USER,
	GET_BEST_DRINKS,
	HAS_FILLED_USER,
	GET_BEST_RESTAURANT,
} from "../../api-routes";
import Allergies from "../../Components/Allergies/Allergies";
import QuestionComponent from "../../Components/QuestionComponent/QuestionComponent";
import { Answer } from "../../Model/Answer";
import UserNavbar from "../../Navbars/UserNavbar";
import * as authService from "../../Auth/AuthService";
import DrinksTable from "../../Components/DrinksTable/DrinskTable";
import { Restaurant } from "../../Model/Restaurant";
import { DrinkDTO } from "../../Model/DrinkDTO";

// toast.configure();
const Questionnaire = () => {
	const customId = "questionnaire";
	const [question, setQuestion] = useState<Question | null>(null);
	const [user, setUser] = useState<User | null>(null);
	//TODO smisliti neki pametniji nacin za saznavanje dal je allergie dodao
	const [filledAllergies, setFilledAllergies] = useState(false);
	const [filled, setFilled] = useState(false);
	const [drinks, setDrinks] = useState<DrinkDTO[] | null>(null);
	const [restaurant, setRestaurant] = useState<Restaurant | null>(null);

	useEffect(() => {
		getUser();
		getFilled();
	}, []);

	const getUser = () => {
		axios
			.get(GET_ONE_USER + Number(authService.getId()))
			.then((response) => {
				setUser(response.data);
			})
			.catch((err) => {});
	};

	const getFilled = () => {
		axios
			.get(HAS_FILLED_USER + Number(authService.getId()))
			.then((response) => {
				setFilled(response.data);
				getBestDrinks();
			})
			.catch((err) => {});
	};

	const getBestDrinks = () => {
		axios
			.get(GET_BEST_DRINKS + Number(authService.getId()))
			.then((response) => {
				console.log(response.data);
				if (!response.data) {
					setDrinks([]);
				} else {
					setDrinks(response.data);
					getBestRestaurant(response.data);
				}
			})
			.catch((err) => {});
	};

	const getBestRestaurant = (drinks: Array<DrinkDTO>) => {
		axios
			.post(GET_BEST_RESTAURANT, { drinks: drinks.map((drink) => drink.drink) })
			.then((response) => {
				console.log(response.data);
				if (!response.data) {
					setRestaurant(null);
				} else {
					setRestaurant(response.data);
				}
			})
			.catch((err) => {});
	};

	const nextQuestion = (question: Question) => {
		if (question.text === "END") {
			getBestDrinks();
			setQuestion(null);
		} else {
			setQuestion(question);
		}
	};

	const added = () => {
		const answer1: Answer = {
			id: 1,
			text: "Below 18",
			answerNumber: 0,
		};

		const answer2: Answer = {
			id: 2,
			text: "Above 18",
			answerNumber: 1,
		};

		const firstQuestion: Question = {
			id: 1,
			text: "Are you 18?",
			answers: [answer1, answer2],
		};
		setQuestion(firstQuestion);
		setFilledAllergies(true);
	};

	return (
		<div>
			<UserNavbar />

			{!filledAllergies && !filled && (
				<div>
					<Allergies added={added} />
				</div>
			)}

			{filledAllergies && question && !filled && (
				<div>
					<QuestionComponent question={question} nextQuestion={nextQuestion} />
				</div>
			)}

			{drinks && filled && (
				<DrinksTable drinks={drinks} restaurant={restaurant} />
			)}
		</div>
	);
};
export default Questionnaire;
