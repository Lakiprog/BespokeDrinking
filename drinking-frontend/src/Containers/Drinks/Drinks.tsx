import { Card, CardBody, Table } from "reactstrap";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import { GET_ALL_DRINKS, SEARCH_FILTER_DRINKS } from "../../api-routes";
import { useEffect, useState } from "react";
import AdminNavbar from "../../Navbars/AdminNavbar";
import { DrinkDTO } from "../../Model/DrinkDTO";
import FilterDrinks from "../../Components/FilterDrinks/FilterDrinks";
import * as authService from "../../Auth/AuthService";
import UserNavbar from "../../Navbars/UserNavbar";

// toast.configure();
const Drinks = () => {
	const customId = "drinks";
	const [drinks, setDrinks] = useState<Array<DrinkDTO> | null>(null);

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

	const filterDrinks = (
		name: string,
		restaurant: string,
		ingredient: string,
		alcoholic: boolean | null,
		caffeine: boolean | null,
		hot: boolean | null
	) => {
		let body = {
			name: name,
			restaurant: restaurant,
			ingredient: ingredient,
			alcoholic: alcoholic,
			caffeine: caffeine,
			hot: hot,
		};
		console.log(body);
		axios
			.post(SEARCH_FILTER_DRINKS, body)
			.then((res: any) => {
				console.log(res.data);
				setDrinks(res.data);
			})
			.catch((err: any) => {});
	};

	return (
		<div>
			{authService.getRole() === "ROLE_ADMIN" && <AdminNavbar />}
			{authService.getRole() === "ROLE_USER" && <UserNavbar />}
			<FilterDrinks filter={filterDrinks} />

			<Card
				className="card-pica"
				style={{ backgroundColor: "#DEEDE6", borderColor: "black" }}
			>
				<CardBody>
					<Table bordered className="div-dokumenti">
						<thead>
							<tr>
								<th>Name</th>
								<th>Alcoholic</th>
								<th>Hot</th>
								<th>Caffeine</th>
								<th>Restaurant</th>
								<th>City</th>
							</tr>
						</thead>

						<tbody>
							{drinks?.map((drink) => {
								return (
									<tr key={drink.id}>
										<td>{drink.name}</td>
										<td>{drink.drink.alcoholic ? 'YES' : 'NO'}</td>
										<td>{drink.drink.hot ? 'YES' : 'NO'}</td>
										<td>{drink.drink.caffeine ? 'YES' : 'NO'}</td>
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
