import { Button, Card, CardBody, CardTitle, Form, FormFeedback, FormGroup, Input, Label } from "reactstrap";
import UnauthenticatedNavbar from "../../Navbars/UnauthenticatedNavbar";
import { yupResolver } from "@hookform/resolvers/yup";
import { registrationSchema } from "./RegistrationSchema";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { User } from "../../Model/User";
import { POST_USER } from "../../api-routes";
import { useForm } from "react-hook-form";

// toast.configure();
const Registration = () => {
    const customId = "registration";

    const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		resolver: yupResolver(registrationSchema),
		mode: "onChange",
	});

    const registration = (user: User) => {
        axios.post(POST_USER, user, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
        })
        .then((res: any) => {

        })
        .catch((err: any) =>{
            
        })
    }

    return(
        <div>
            <UnauthenticatedNavbar />

            <Card className="card-login-registracija" style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}>
                <CardBody>
                        <CardTitle tag="h2">Registration</CardTitle>
                        <Form className="form-login-registracija">

                            <FormGroup>
                                <Label>Username</Label>
                                <Input
                                    type="text"
                                    name="Username"
                                    placeholder="Username"
                                    invalid={errors.Username?.message}
                                    innerRef={register}
                                />
                                <FormFeedback>{errors.Username?.message}</FormFeedback>
                            </FormGroup>

                            <FormGroup>
                                <Label>Password</Label>
                                <Input
                                    type="text"
                                    name="Password"
                                    placeholder="Password"
                                    invalid={errors.Password?.message}
                                    innerRef={register}
                                />
                                <FormFeedback>{errors.Password?.message}</FormFeedback>
                            </FormGroup>

                            <FormGroup>
                                <Label>City</Label>
                                <Input
                                    type="text"
                                    name="City"
                                    placeholder="NS"
                                    invalid={errors.City?.message}
                                    innerRef={register}
                                />
                                <FormFeedback>{errors.City?.message}</FormFeedback>
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
        </div>
    )
}
export default Registration;