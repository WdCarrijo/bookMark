package br.gov.serpro.bookmark.message;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.Message;

public interface InfoMessages {
	final Message BOOKMARK_DELETE_OK = new DefaultMessage("{bookmark-delete-ok}");
	final Message BOOKMARK_INSERT_OK = new DefaultMessage("{bookmark-insert-ok}");
	final Message BOOKMARK_UPDATE_OK = new DefaultMessage("{bookmark-update-ok}");
}
