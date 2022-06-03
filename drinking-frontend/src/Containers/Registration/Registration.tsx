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
import UnauthenticatedNavbar from "../../Navbars/UnauthenticatedNavbar";
import { yupResolver } from "@hookform/resolvers/yup";
import { registrationSchema } from "./RegistrationSchema";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { User } from "../../Model/User";
import { POST_USER } from "../../api-routes";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const Registration = () => {
	const customId = "registration";

	const navigate = useNavigate();

	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		mode: "onChange",
		resolver: yupResolver(registrationSchema),
	});

	const registration = (user: User) => {
		axios
			.post(POST_USER, user)
			.then((res: any) => {
				navigate("/");
			})
			.catch((err: any) => {
				toast.error(err.response.data, {
					position: toast.POSITION.TOP_CENTER,
					autoClose: false,
					toastId: customId,
				});
			});
	};

	return (
		<>
			<UnauthenticatedNavbar />

			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">Registration</CardTitle>
					<Form className="form-login-registracija">
						<FormGroup>
							<Label>Username</Label>
							<Input
								type="text"
								name="username"
								placeholder="Username"
								invalid={errors.username?.message}
								innerRef={register}
							/>
							<FormFeedback>{errors.username?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>Password</Label>
							<Input
								type="text"
								name="password"
								placeholder="Password"
								invalid={errors.password?.message}
								innerRef={register}
							/>
							<FormFeedback>{errors.password?.message}</FormFeedback>
						</FormGroup>

						<FormGroup>
							<Label>City</Label>
							<Input
								type="text"
								name="city"
								placeholder="NS"
								invalid={errors.city?.message}
								innerRef={register}
							/>
							<FormFeedback>{errors.city?.message}</FormFeedback>
						</FormGroup>

						<Button
							className="registruj-login-btn"
							color="primary"
							type="button"
							onClick={handleSubmit(registration)}
						>
							Register
						</Button>
					</Form>
				</CardBody>
			</Card>
		</>
	);
};
export default Registration;
