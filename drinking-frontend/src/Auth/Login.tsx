import {
	Button,
	Form,
	FormGroup,
	Label,
	Input,
	Card,
	CardTitle,
	CardBody,
	FormFeedback,
} from "reactstrap";
import { yupResolver } from "@hookform/resolvers/yup";
import axios from "axios";
import { useForm } from "react-hook-form";
import "react-toastify/dist/ReactToastify.css";
import { loginSchema } from "./LoginSchema";
import * as authService from "./AuthService";
import UnauthenticatedNavbar from "../Navbars/UnauthenticatedNavbar";
import { useNavigate } from "react-router-dom";

const Login = () => {
	const customId = "login";

	const navigate = useNavigate();

	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		resolver: yupResolver(loginSchema),
		mode: "onChange",
	});

	const login = (user: any) => {
		axios
			.post("http://localhost:8080/auth/login", user)
			.then((res: any) => {
				authService.storeToken(res.data);
				if (authService.getRole() === "ROLE_USER") {
					navigate("/questionnaire");
				} else if (authService.getRole() === "ROLE_ADMIN") {
					navigate("/restaurants");
				}
			})
			.catch((err: any) => {
				let message = "";
				if (err.response.status === 404) {
					message = "Invalid Credentials!";
				}
				// toast.error(message, {
				// 	position: toast.POSITION.TOP_CENTER,
				// 	autoClose: false,
				// 	toastId: customId,
				// });
			});
	};

	return (
		<div>
			<UnauthenticatedNavbar />
			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<CardTitle tag="h2">Login</CardTitle>
					<Form className="form-login-registracija">
						<FormGroup>
							<Label>Username</Label>
							<Input
								type="text"
								name="username"
								invalid={errors.username?.message}
								innerRef={register}
							/>
							<FormFeedback>{errors.username?.message}</FormFeedback>
						</FormGroup>
						<FormGroup>
							<Label>Password</Label>
							<Input
								type="password"
								name="password"
								invalid={errors.password?.message}
								innerRef={register}
							/>
							<FormFeedback>{errors.password?.message}</FormFeedback>
						</FormGroup>
						<Button
							className="registruj-login-btn"
							color="primary"
							type="button"
							onClick={handleSubmit(login)}
						>
							Login
						</Button>
					</Form>
				</CardBody>
			</Card>
		</div>
	);
};

export default Login;
