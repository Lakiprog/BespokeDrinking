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
import { ANSWER_QUESTION } from "../../api-routes";
import { useState } from "react";
import * as authService from "../../Auth/AuthService";

// toast.configure();
const QuestionComponent = (props: {
	question: any;
	nextQuestion: Function;
}) => {
	const customId = "questionComponent";
	const [selectedAnswer, setAnswer] = useState<Answer | null>(null);

	const answer = () => {
		let copy = props.question;
		let answeredQuestion = {
			processed: false,
			answer: selectedAnswer,
			question: copy,
		};

		axios
			.put(ANSWER_QUESTION + Number(authService.getId()), answeredQuestion)
			.then((response) => {
				props.nextQuestion(response.data);
			})
			.catch((err: any) => {});
	};

	return (
		<div>
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">{props.question.text}</CardTitle>

					<Form>
						{props.question.answers.map((answer: Answer) => (
							<div key={answer.id}>
								<Label>{answer.text}</Label>
								<Input
									className="ml-2"
									type="radio"
									name={props.question.text}
									value={answer.id}
									onChange={() => setAnswer(answer)}
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
						onClick={() => answer()}
					>
						Next question
					</Button>
				</CardBody>
			</Card>
		</div>
	);
};
export default QuestionComponent;
