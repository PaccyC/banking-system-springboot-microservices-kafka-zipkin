import { StatisticsChart } from "../charts/StatisticsChart"
import ExpenseCard from "../components/ExpenseCard"

import { AiOutlineArrowUp } from "react-icons/ai";
import { BsArrowRight } from "react-icons/bs";
import { AiOutlineArrowDown } from "react-icons/ai";
const Expenses = () => {
  return (
    <div className="w-full flex flex-col gap-6">
      <div className="flex flex-col gap-4">
        <h3 className="font-inter font-normal text-[22px] text-gray-1">Expenses Comparison</h3>
        <div className="bg-white  rounded-[8px] min-h-[200px] py-5 px-6 max-h-[400px]">

          <StatisticsChart />

        </div>

      </div>
      <div className=" flex flex-col gap-4">
        <h3 className="font-inter font-normal text-[22px] text-gray-1">Expenses Breakdown</h3>
        <div className=" w-full  grid sm:grid-cols-1 md:grid-cols-2 justify-center lg:grid-cols-3 gap-6 flex-grow">
          <ExpenseCard
          date="17 May 2023"
          first_expense_amount={230.00}
          second_expense_amount={20.00}
          descriptionImage="/icons/Housing.svg"
          expenseCategory="Housing"
          percentage={15}
          first_expense="House Rent"
          second_expense="Parking"
          indicatorIcon={<AiOutlineArrowUp className="text-light-red"/>}
        />
         <ExpenseCard
          date="17 May 2023"
          first_expense_amount={230.00}
          second_expense_amount={120.00}
          descriptionImage="/icons/Housing.svg"
          expenseCategory="Food"
          percentage={0.8}
          first_expense="Grocery"
          second_expense="Reastaurant Bill"
          indicatorIcon={<AiOutlineArrowDown className=" text-primary-1"/>}
        />
         <ExpenseCard
          date="17 May 2023"
          first_expense_amount={30.00}
          second_expense_amount={20.00}
          descriptionImage="/icons/Trasnport.svg"
          expenseCategory="Transportation"
          percentage={12}
          first_expense="Taxi Fare"
          second_expense="Metro Card Bill"
          indicatorIcon={<AiOutlineArrowDown className=" text-primary-1"/>}
        />
         <ExpenseCard
          date="17 May 2023"
          first_expense_amount={30.00}
          second_expense_amount={30.00}
          descriptionImage="/icons/Housing.svg"
          expenseCategory="Entertainment"
          percentage={15}
          first_expense="Movie Bucket"
          second_expense="ITunes"
          indicatorIcon={<AiOutlineArrowDown className=" text-primary-1"/>}
        />
         <ExpenseCard
          date="17 May 2023"
          first_expense_amount={230.00}
          second_expense_amount={190.00}
          descriptionImage="/icons/Shopping.svg"
          expenseCategory="Shopping"
          percentage={25}
          first_expense="House Rent"
          second_expense="Parking"
          indicatorIcon={<AiOutlineArrowUp className=" text-light-red"/>}
        />
         <ExpenseCard
          date="17 May 2023"
          first_expense_amount={30.00}
          second_expense_amount={20.00}
          descriptionImage="/icons/Housing.svg"
          expenseCategory="Others"
          percentage={30}
          first_expense="Donation"
          second_expense="Gift"
          indicatorIcon={<AiOutlineArrowUp className=" text-light-red"/>}
        />

        </div>

      </div>
    </div>
  )
}

export default Expenses