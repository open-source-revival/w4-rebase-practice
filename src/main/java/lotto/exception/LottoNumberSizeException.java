package lotto.exception;

public class LottoNumberSizeException extends IllegalArgumentException {
	public LottoNumberSizeException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.INVALID_PURCHASE_AMOUNT);
	}
}
