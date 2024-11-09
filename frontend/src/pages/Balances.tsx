import BalanceComponent from "../components/BalanceComponent"

const Balances = () => {
  return (
    <div className=" w-full flex flex-col gap-4">
      <h3 className=" font-inter font-normal text-[22px] text-gray-1">Balances</h3>

      <div className=" grid grid-cols-3 gap-4 flex-grow">
        <BalanceComponent
         balanceType="Credit Card"
          accountNumber="3388 4556  8860 8***"
          totalAmount={25000}
          bankName="Master Card"
          bankImage="/icons/Mastercard.svg"
        />
           <BalanceComponent
         balanceType="Credit Card"
          accountNumber="3388 4556  8860 8***"
          totalAmount={25000}
          bankName="Master Card"
          bankImage="/icons/Mastercard.svg"
        />
           <BalanceComponent
         balanceType="Credit Card"
          accountNumber="3388 4556  8860 8***"
          totalAmount={25000}
          bankName="Master Card"
          bankImage="/icons/Mastercard.svg"
        />
           <BalanceComponent
         balanceType="Credit Card"
          accountNumber="3388 4556  8860 8***"
          totalAmount={25000}
          bankName="Master Card"
          bankImage="/icons/Mastercard.svg"
        />
           <BalanceComponent
         balanceType="Credit Card"
          accountNumber="3388 4556  8860 8***"
          totalAmount={25000}
          bankName="Master Card"
          bankImage="/icons/Mastercard.svg"
        />

        <div className=" bg-white min-h-[200px] h-full rounded-[8px] px-24 flex flex-col gap-4 items-center justify-center">
        <button className=" text-white w-full bg-primary-1 rounded-[4px] py-2 px-5 font-inter font-bold text-[16px] flex gap-2 items-center justify-center">
                Add Accounts 
        </button>
        <p 
        onClick={()=>{}}
        className=" text-gray-1 font-inter font-medium text-[16px] cursor-pointer ">Edit Accounts </p>
        </div>
      </div>
      
    </div>
  )
}

export default Balances