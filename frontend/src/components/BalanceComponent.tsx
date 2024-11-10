
import { FiChevronRight } from "react-icons/fi";
import { useNavigate } from "react-router-dom";
interface BalanceComponentProps{
    balanceType: string;
    accountNumber: string;
    totalAmount: number;
    bankName: string;
    bankImage?: string;
}
const BalanceComponent = ({balanceType,accountNumber,totalAmount,bankName,bankImage}:BalanceComponentProps) => {
    const navigate = useNavigate();
  return (
    <div className=" bg-white min-h-[200px] rounded-[8px] p-6 flex flex-col gap-4">
        <div className=" flex justify-between items-center">
            <h3 className="text-[16px] font-inter font-bold text-gray-1">{balanceType}</h3>
            <div className=" flex items-center gap-3">
                <p className=" text-[#666666] font-inter font-medium text-[14px]">{bankName}</p>
                {bankImage && 
                 <img src={bankImage}  />
                }
                
            </div>
        </div>

        <hr className=" h-[2px] bg-light-gray-2"/>
        <div className=" flex flex-col gap-3">
           <div className=" flex flex-col gap-2">
            <h3 className=" font-inter font-semibold text-[20px] text-dark-1">{accountNumber}</h3>
            <p className=" font-inter font-normal tet-[14px] text-light-gray-4">Account Number</p>
           </div>
           <div className=" flex flex-col gap-2">
            <h3 className=" font-inter font-semibold text-[20px] text-dark-1">${totalAmount}</h3>
            <p className=" font-inter font-normal tet-[14px] text-light-gray-4">Total amount</p>
           </div>
        </div>

        {/* Remove and details */}

        <div className=" flex justify-between items-center">
            <p 
            onClick={()=>{}}
            className="font-inter font-normal tet-[14px] text-primary-1"
            >Remove</p>

            <button 
            onClick={()=>navigate('/account-details')}
              className=" text-white bg-primary-1 rounded-[4px] py-2 px-5 font-inter font-medium text-[14px] flex gap-2 items-center">
              Details <FiChevronRight className=" text-white"/>
            </button>
        </div>
    </div>
  )
}

export default BalanceComponent