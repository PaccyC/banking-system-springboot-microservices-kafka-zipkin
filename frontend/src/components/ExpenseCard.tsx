
import { ReactNode } from "react";

interface ExpenseCardProps{
  percentage: number;
  descriptionImage: string;
  expenseCategory:string;
  first_expense: string;
  second_expense: string;
  date: string;
  first_expense_amount: number;
  second_expense_amount: number;
  indicatorIcon: ReactNode

}
const ExpenseCard = ({percentage,descriptionImage,expenseCategory,first_expense,second_expense,date,first_expense_amount,second_expense_amount,indicatorIcon}:ExpenseCardProps) => {
  const totalAmount= first_expense_amount + second_expense_amount;
  return (
    <div className="bg-white flex flex-col gap-0 mn-h-[200px] rounded-[8px] px-0 py-0 w-full shadow-lg">
      <div className="h-[30%] w-full bg-gray-5 flex  justify-between px-4 py-4 rounded-t-[8px]">
        <div className=" flex gap-3 items-center">
          <div className=" px-3 py-4 bg-light-gray-4 rounded-[4px]">
            <img src={descriptionImage} 
            alt="expense" />
          </div>
          <div className=" flex flex-col gap-1 ">
            <p className=" text-gray-3 font-semibold font-inter text-[16px]">{expenseCategory}</p>
            <h3 className=" text-dark-1 font-inter font-bold text-[20px]">${totalAmount}</h3>
          </div>
        </div>
          <div className=" flex flex-col gap-2 items-end">
            <div className=" flex gap-2 items-center">
              <p className="text-dark-2 font-semibold font-inter text-[16px]">{percentage}%</p>
              {indicatorIcon}

            </div>
            <p className="font-inter font-medium text-[14px] text-light-gray-4">Compare to last month</p>
          </div>
      </div>
        
      <div className="bg-white px-4 py-4 flex flex-col gap-3">
        <div className=" flex justify-between items-center">
         <h3 className=" text-dark-2 font-inter font-semibold text-[16px]">{first_expense}</h3>
         <div className=" flex flex-col gap-1 items-end">
          <h4 className="text-dark-2 font-semibold font-inter text-[16px]">${first_expense_amount}</h4>
          <p className="font-inter font-medium text-[14px] text-light-gray-4">{date}</p>
         </div>
        </div>
        <hr className=" h-[2px] bg-light-gray-2"/>

        <div className=" flex justify-between items-center">
         <h3 className="text-dark-2 font-inter font-semibold text-[16px]">{second_expense}</h3>
         <div className=" flex flex-col gap-1 items-end">
          <h4 className="text-dark-2 font-semibold font-inter text-[16px]">${second_expense_amount}</h4>
          <p className="font-inter font-medium text-[14px] text-light-gray-4">{date}</p>
         </div>
        </div>
      </div>

    </div>
  )
}

export default ExpenseCard