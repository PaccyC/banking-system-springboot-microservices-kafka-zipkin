import { FiEdit3 } from "react-icons/fi";


interface ExpenseCategoryProps{
    descriptionImage: string;
    categoryName: string;
    totalAmount: number;
    handleClick : () => void;
}
const ExpenseCategory = ({descriptionImage,categoryName,totalAmount,handleClick}:ExpenseCategoryProps) => {
    

    
  return (
    <div className=" bg-white py-6 px-6 rounded-[8px] flex justify-between shadow-sm">
        <div className=" flex gap-4 items-center">
        <div className=" px-3 py-4 bg-light-gray-2 rounded-[4px]">
            <img src={descriptionImage} 
            alt="expense" />
          </div>
         <div className=" flex flex-col gap-1">
          <p className=" text-gray-3 font-semibold font-inter text-[16px]">{categoryName}</p>
          <h3 className=" text-dark-1 font-bold font-inter text-[20px]">${totalAmount}</h3>
         </div> 
        </div>
        <button 
            onClick={handleClick}
            className=" border-[2px] border-primary-1 rounded-[8px] px-8 py-2 self-center text-primary-1 font-semibold font-inter  flex items-center">
            
            Adjust  
            <FiEdit3 className=" text-primary-1 ml-3"/>
           </button>
    </div>
  )
}

export default ExpenseCategory