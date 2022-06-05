import {
	Button,
	Card,
	CardBody,
	CardTitle,
	Form,
	Input,
	Label,
} from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import { Answer } from "../../Model/Answer";
import axios from "axios";
import {
	HAS_FILLED_USER,
	ANSWER_QUESTION,
	GET_CREATED_UNANSWERED_QUESTIONS,
} from "../../api-routes";
import { useEffect, useState } from "react";
import * as authService from "../../Auth/AuthService";
import { Question } from "../../Model/Question";
import UserNavbar from "../../Navbars/UserNavbar";
import { AnsweredQuestion } from "../../Model/AnsweredQuestion";
import { useForm } from "react-hook-form";

const UpdatePreference = () => {
	const [filled, setFilled] = useState(false);
	const [unansweredCreatedQuestions, setUnansweredCreatedQuestions] = useState<
		Question[]
	>([]);
	const [checked, setChecked] = useState<number>(0);

	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		mode: "onChange",
	});

	useEffect(() => {
		getFilled();
	}, []);

	const getFilled = () => {
		axios
			.get(HAS_FILLED_USER + Number(authService.getId()))
			.then((response) => {
				setFilled(response.data);
				getUnansweredCreatedQuestions(response.data);
			})
			.catch((err) => {});
	};

	const getUnansweredCreatedQuestions = (canFill: boolean) => {
		if (canFill) {
			axios
				.get(GET_CREATED_UNANSWERED_QUESTIONS + Number(authService.getId()))
				.then((response) => {
					console.log(response.data);
					setUnansweredCreatedQuestions(response.data);
				})
				.catch((err: any) => {});
		}
	};

	const answerQuestion = (aq: AnsweredQuestion) => {
		let selectedQuestion = null;
		for (let i = 0; i < unansweredCreatedQuestions.length; i++) {
			for (
				let j = 0;
				j < unansweredCreatedQuestions.at(i)!.answers.length;
				j++
			) {
				if (
					Number(aq.answerId) ===
					unansweredCreatedQuestions.at(i)!.answers.at(j)!.id
				) {
					selectedQuestion = unansweredCreatedQuestions.at(i)!;
					break;
				}
			}
		}
		const selectedAnswer = selectedQuestion!.answers.filter(
			(a) => a.id === Number(aq.answerId)
		);
		let answeredQuestion = {
			processed: false,
			answer: selectedAnswer.at(0)!,
			question: selectedQuestion,
		};
		console.log(answeredQuestion);
		axios
			.put(ANSWER_QUESTION + Number(authService.getId()), answeredQuestion)
			.then((response) => {
				console.log(response.data);
				getUnansweredCreatedQuestions(filled);
			})
			.catch((err: any) => {});
	};

	return (
		<div>
			<UserNavbar />
			{!filled && (
				<Card
					className="card-login-registracija"
					style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
				>
					<CardBody>
						<CardTitle tag="h3">
							You have to fill the main questionnaire first before answering
							additional questions
						</CardTitle>
					</CardBody>
				</Card>
			)}
			{unansweredCreatedQuestions.length === 0 && filled && (
				<Card
					className="card-login-registracija"
					style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
				>
					<CardBody>
						<CardTitle tag="h2">There no available questions</CardTitle>
					</CardBody>
				</Card>
			)}
			{unansweredCreatedQuestions.length > 0 &&
				unansweredCreatedQuestions.map((question: Question) => (
					<Card
						className="card-login-registracija"
						style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
					>
						<CardBody>
							<CardTitle tag="h2">{question.text}</CardTitle>

							<Form>
								<Input
									className="ml-2"
									type="text"
									name="questionId"
									value={question.id}
									innerRef={register}
									hidden
								/>
								{question.answers.map((answer: Answer) => (
									<div key={answer.id}>
										<Label>{answer.text}</Label>
										<Input
											className="ml-2"
											type="radio"
											name="answerId"
											checked={checked === answer.id}
											onChange={() => setChecked(answer.id)}
											value={answer.id}
											innerRef={register}
											required
										>
											{answer.text}
										</Input>
									</div>
								))}
							</Form>

							<Button
								className="ingredient-btn"
								color="primary"
								type="button"
								onClick={handleSubmit(answerQuestion)}
							>
								Answer question
							</Button>
						</CardBody>
					</Card>
				))}
		</div>
	);
};
export default UpdatePreference;
