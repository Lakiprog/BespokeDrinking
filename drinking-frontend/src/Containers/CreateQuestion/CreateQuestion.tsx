import {
	Button,
	Card,
	CardBody,
	CardTitle,
	Form,
	FormFeedback,
	FormGroup,
	Input,
	Label,
} from "reactstrap";
import axios from "axios";
import { CREATE_NEW_QUESTION } from "../../api-routes";
import { NewQuestion } from "../../Model/NewQuestion";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { createQuestionSchema } from "./CreateQuestionSchema";
import AdminNavbar from "../../Navbars/AdminNavbar";

const CreateQuestion = () => {
	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		mode: "onChange",
		resolver: yupResolver(createQuestionSchema),
	});

	const createNewQuestion = (newQuestion: NewQuestion) => {
		axios
			.post(CREATE_NEW_QUESTION, newQuestion)
			.then((response) => {
				console.log(response);
			})
			.catch((err: any) => {});
	};

	return (
		<div>
			<AdminNavbar />
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2"></CardTitle>

					<Form>
						<FormGroup>
							<Label>Question text</Label>
							<Input
								className="ml-2"
								type="text"
								name="text"
								invalid={errors.text?.message}
								innerRef={register}
							></Input>
							<FormFeedback>{errors.text?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>First answer text</Label>
							<Input
								className="ml-2"
								type="text"
								name="firstAnswerText"
								invalid={errors.firstAnswerText?.message}
								innerRef={register}
							></Input>
							<FormFeedback>{errors.firstAnswerText?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>Taste for first answer</Label>
							<Input
								type="select"
								name="firstAnswerKey"
								className="ml-2"
								innerRef={register}
							>
								<option>SWEET</option>
								<option>BITTER</option>
								<option>SOUR</option>
								<option>SALTY</option>
								<option>UMAMI</option>
							</Input>
						</FormGroup>

						<FormGroup>
							<Label>Taste value for first answer</Label>
							<Input
								className="ml-2"
								type="number"
								name="firstAnswerValue"
								defaultValue={0}
								min="0"
								invalid={errors.firstAnswerValue?.message}
								innerRef={register}
							></Input>
							<FormFeedback>{errors.firstAnswerValue?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>Second answer text</Label>
							<Input
								className="ml-2"
								type="text"
								name="secondAnswerText"
								invalid={errors.secondAnswerText?.message}
								innerRef={register}
							></Input>
							<FormFeedback>{errors.secondAnswerText?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>Taste for second answer</Label>
							<Input
								type="select"
								name="secondAnswerKey"
								className="ml-2"
								innerRef={register}
							>
								<option>SWEET</option>
								<option>BITTER</option>
								<option>SOUR</option>
								<option>SALTY</option>
								<option>UMAMI</option>
							</Input>
						</FormGroup>

						<FormGroup>
							<Label>Taste value for second answer</Label>
							<Input
								className="ml-2"
								type="number"
								name="secondAnswerValue"
								defaultValue={0}
								min="0"
								invalid={errors.secondAnswerValue?.message}
								innerRef={register}
							></Input>
							<FormFeedback>{errors.secondAnswerValue?.message}</FormFeedback>
						</FormGroup>
					</Form>

					<Button
						className="ingredient-btn"
						color="primary"
						type="button"
						onClick={handleSubmit(createNewQuestion)}
					>
						Create question
					</Button>
				</CardBody>
			</Card>
		</div>
	);
};
export default CreateQuestion;
