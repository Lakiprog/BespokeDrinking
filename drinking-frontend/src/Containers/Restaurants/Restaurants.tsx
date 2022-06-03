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
	Modal,
	ModalBody,
	ModalHeader,
	Table,
} from "reactstrap";
import { yupResolver } from "@hookform/resolvers/yup";
import { restaurantSchema } from "./RestaurantSchema";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import {
	GET_ALL_RESTAURANTS,
	POST_RESTAURANT,
	SEARCH_FILTER_RESTAURANTS,
} from "../../api-routes";
import { useForm } from "react-hook-form";
import { Restaurant } from "../../Model/Restaurant";
import { useEffect, useState } from "react";
import AddDrinkModal from "../../Components/AddDrinkModal/AddDrinkModal";
import AdminNavbar from "../../Navbars/AdminNavbar";
import FilterRestaurants from "../../Components/FilterRestaurants/FilterRestaurants";
import * as authService from "../../Auth/AuthService";
import UserNavbar from "../../Navbars/UserNavbar";

// toast.configure();
const Restaurants = () => {
	const customId = "restaurants";
	const [restaurants, setRestaurants] = useState<Array<Restaurant> | null>(
		null
	);
	const [showModal, setShowModal] = useState(false);
	const [currentRestaurant, setRestaurant] = useState<Restaurant | null>(null);

	const toggle = () => setShowModal(!showModal);

	useEffect(() => {
		getRestaurants();
	}, []);

	const {
		register,
		handleSubmit,
		formState: { errors },
	} = useForm({
		resolver: yupResolver(restaurantSchema),
		mode: "onChange",
	});

	const getRestaurants = () => {
		axios
			.get(GET_ALL_RESTAURANTS)
			.then((res: any) => {
				setRestaurants(res.data);
				console.log(res.data);
			})
			.catch((err: any) => {});
	};

	const filterRestaurants = (name: string, city: string) => {
		let body = {
			name: name,
			city: city,
		};
		axios
			.post(SEARCH_FILTER_RESTAURANTS, body)
			.then((res: any) => {
				console.log(res.data);
				setRestaurants(res.data);
			})
			.catch((err: any) => {});
	};

	const addRestaurant = (restaurant: Restaurant) => {
		axios
			.post(POST_RESTAURANT, restaurant)
			.then((res: any) => {
				getRestaurants();
			})
			.catch((err: any) => {});
	};

	const addDrink = (restaurant: Restaurant) => {
		toggle();
		setRestaurant(restaurant);
	};

	return (
		<div>
			{authService.getRole() === "ROLE_ADMIN" && (
				<>
					<AdminNavbar />{" "}
					<Card
						className="card-login-registracija"
						style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
					>
						<CardBody>
							<CardTitle tag="h2">Add Restaurant</CardTitle>
							<Form className="form-login-registracija">
								<FormGroup>
									<Label>Name</Label>
									<Input
										type="text"
										name="name"
										placeholder="name"
										invalid={errors.name?.message}
										innerRef={register}
									/>
									<FormFeedback>{errors.name?.message}</FormFeedback>
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
									onClick={handleSubmit(addRestaurant)}
								>
									Add restaurant
								</Button>
							</Form>
						</CardBody>
					</Card>
				</>
			)}
			{authService.getRole() === "ROLE_USER" && (
				<>
					<UserNavbar />
				</>
			)}

			<FilterRestaurants filter={filterRestaurants} />

			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<Table bordered className="div-dokumenti">
						<thead>
							<tr>
								<th>Name</th>
								<th>City</th>
								{authService.getRole() === "ROLE_ADMIN" && <th>Add drinks</th>}
							</tr>
						</thead>

						<tbody>
							{restaurants?.map((restaurant) => {
								return (
									<tr key={restaurant.id}>
										<td>{restaurant.name}</td>
										<td>{restaurant.city}</td>
										{authService.getRole() === "ROLE_ADMIN" && (
											<td>
												<Button
													className="table-button"
													color="primary"
													type="button"
													onClick={() => addDrink(restaurant)}
												>
													Add Drink
												</Button>
											</td>
										)}
									</tr>
								);
							})}
						</tbody>
					</Table>
				</CardBody>
			</Card>

			<Modal isOpen={showModal} toggle={toggle} className="add-drink-modal">
				<ModalHeader toggle={toggle} style={{ backgroundColor: "#DEEDE6" }}>
					Add Drink
				</ModalHeader>

				{currentRestaurant && (
					<ModalBody style={{ backgroundColor: "#DEEDE6" }}>
						<AddDrinkModal restaurant={currentRestaurant} close={toggle} />
					</ModalBody>
				)}
			</Modal>
		</div>
	);
};
export default Restaurants;
