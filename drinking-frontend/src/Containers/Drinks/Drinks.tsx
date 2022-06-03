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
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { GET_ALL_DRINKS, GET_ALL_RESTAURANTS, POST_RESTAURANT } from "../../api-routes";
import { useForm } from "react-hook-form";
import { Restaurant } from "../../Model/Restaurant";
import { useEffect, useState } from "react";
import AddDrinkModal from "../../Components/AddDrinkModal/AddDrinkModal";
import AdminNavbar from "../../Navbars/AdminNavbar";
import FilterRestaurants from "../../Components/FilterRestaurants/FilterRestaurants";
import { DrinkDTO } from "../../Model/DrinkDTO";
import FilterDrinks from "../../Components/FilterDrinks/FilterDrinks";

// toast.configure();
const Drinks = () => {
	const customId = "drinks";
	const [drinks, setDrinks] = useState<Array<DrinkDTO> | null>(
		null
	);

	useEffect(() => {
		getDrinks();
	}, []);

	const getDrinks = () => {
		axios
			.get(GET_ALL_DRINKS)
			.then((res: any) => {
				setDrinks(res.data);
			})
			.catch((err: any) => {});
	};

	//TODO pozvati endpoint i setovati restorane
	const filterDrinks = (name :string, restaurant: string, ingredient: string, 
		alcohol: boolean | null, coffein: boolean | null, hot: boolean | null) => {

	}

	return (
		<div>
			<AdminNavbar />

			<FilterDrinks filter={filterDrinks}/>

			<Card
				className="card-login-registracija"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<Table bordered className="div-dokumenti">
						<thead>
							<tr>
								<th>Name</th>
								<th>Restaurant</th>
								<th>City</th>
							</tr>
						</thead>

						<tbody>
							{drinks?.map((drink) => {
								return (
									<tr key={drink.id}>
										<td>{drink.name}</td>
										<td>{drink.restaurant}</td>
										<td>{drink.city}</td>
									</tr>
								);
							})}
						</tbody>
					</Table>
				</CardBody>
			</Card>

		</div>
	);
};
export default Drinks;
