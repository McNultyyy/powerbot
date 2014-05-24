package org.powerbot.script.rt6;

import org.powerbot.bot.rt6.client.Client;

/**
 * {@link Varpbits} is a utility which provides raw access to the game's varpbits.
 */
public class Varpbits extends ClientAccessor {
	public Varpbits(final ClientContext factory) {
		super(factory);
	}

	/**
	 * Returns the array of settings for the game.
	 *
	 * @return an array of the game's settings
	 */
	public int[] array() {
		final Client client = ctx.client();
		if (client == null) {
			return null;
		}
		final int[] arr = client.getPlayerMetaInfo().getSettings().getData();
		return arr != null ? arr.clone() : new int[0];
	}

	/**
	 * Returns the array of a specified index.
	 *
	 * @param index the index of the setting
	 * @return the setting for the specified index
	 */
	public int varpbit(final int index) {
		final int[] arr = array();
		return index > -1 && index < arr.length ? arr[index] : -1;
	}
}
