import { RxCross2 } from "react-icons/rx";

interface CloseModalProps{
    closeModal: () => void;
} 
const EditGoal = ({ closeModal }:CloseModalProps) => {
    return (
        <div className="relative lg:w-[500px] min-h-[200px] bg-white py-12 px-10 rounded-[16px] shadow-lg">
            <RxCross2
                onClick={closeModal}
                size={24}
                className="text-dark-2 cursor-pointer absolute right-6 top-6"
            />

            <form action="">
                <div className="flex flex-col gap-4">
                    <div className="flex flex-col gap-2">
                        <label className="font-inter font-semibold text-[16px] text-dark-2">
                            Target Amounts
                        </label>
                        <input
                            type="text"
                            placeholder="$500000"
                            name="amount"
                            className="w-full px-3 py-3 border border-light-gray-5 focus:border-light-gray-5 rounded-[8px] text-gray-1"
                        />
                    </div>
                    <div className="flex flex-col gap-2">
                        <label className="font-inter font-semibold text-[16px] text-dark-2">
                            Present Amounts
                        </label>
                        <input
                            type="text"
                            placeholder="Write present amounts here"
                            name="amount"
                            className="w-full px-3 py-3 border border-light-gray-5 focus:border-light-gray-5 rounded-[8px] text-gray-1"
                        />
                    </div>

                    <button
                        type="submit"
                        className="bg-primary-1 py-3 px-6 text-white rounded-[4px] text-[16px] font-bold font-inter w-[50%] self-center cursor-pointer"
                    >
                        Save
                    </button>
                </div>
            </form>
        </div>
    );
};

export default EditGoal;
