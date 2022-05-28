import UnauthenticatedNavbar from "../../Navbars/UnauthenticatedNavbar";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState } from "react";
import { Question } from "../../Model/Question";
import { User } from "../../Model/User";
import axios from "axios";
import { GET_ONE_USER } from "../../api-routes";
import Allergies from "../../Components/Allergies/Allergies";
import QuestionComponent from "../../Components/QuestionComponent/QuestionComponent";
import { AnsweredQuestion } from "../../Model/AnsweredQuestion";
import { Answer } from "../../Model/Answer";

// toast.configure();
const Questionnaire = () => {
	const customId = "questionnaire";
	const [question, setQuestion] = useState<Question | null>(
		null
	);
	const [user, setUser] = useState<User | null>(null)
	//TODO smisliti neki pametniji nacin za saznavanje dal je allergie dodao
	const [filledAllergies, setFilledAllergies] = useState(false);

	useEffect(() => {
		getUser();
	}, []);

	const getUser = () => {
		//TODO kad imamo login zameniti id
		axios
		.get(GET_ONE_USER + 1)
		.then(response => {
			setUser(response.data);
		})
		.catch(err => {

		})
	}

	const nextQuestion = (question : Question) => {
		setQuestion(question);
	}

	const added = () => {
		const answer1: Answer = {
			id: 1,
			text: 'Below 18',
			answerNumber: 0
		}

		const answer2 : Answer = {
			id : 2,
			text: 'Above 18',
			answerNumber: 1
		}

		const firstQuestion : Question= {
			id: 1,
			text : 'Are you 18?',
			answers : [answer1, answer2]
		}
		setQuestion(firstQuestion);
		setFilledAllergies(true)
	}

	return (
		<div>
			<UnauthenticatedNavbar />

			{!filledAllergies &&
				(<div>
					<Allergies added={added}/>
				</div>)
			}

			{filledAllergies &&
				(<div>
					<QuestionComponent question={question} nextQuestion={nextQuestion}/>
				</div>)
			}
		</div>
	);
};
export default Questionnaire;
