package org.qqq175.textparser.postprocess;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;
import org.qqq175.textparser.exceptions.UnacceptableArgument;
import org.qqq175.textparser.visitor.CountLexemeVisitor;
import org.qqq175.textparser.visitor.PrintTextVisitor;
import org.qqq175.textparser.visitor.SwapFirstLastVisitor;
import org.qqq175.textparser.visitor.TextVisitor;

public class TextUtil {
	public void swapSentenceLexemes(TextComposite textRoot) throws UnacceptableArgument {
		if (textRoot instanceof TextComposite) {
			SwapFirstLastVisitor swapVisitor = new SwapFirstLastVisitor();
			textRoot.getChildrenList().forEach(par -> par.getChildrenList().forEach(sent -> sent.accept(swapVisitor)));
		} else {
			throw new UnacceptableArgument("Root is not a Text");
		}
	}

	public TextComposite sortSenteneceByLexemeCount(TextComposite textRoot) throws UnacceptableArgument {
		List<SentenseComposite> sentenses = new ArrayList<>();
		if (textRoot instanceof TextComposite) {
			textRoot.getChildrenList().forEach(par -> par.getChildrenList().forEach(sent -> sentenses.add(sent)));
		} else {
			throw new UnacceptableArgument("Root is not a Text");
		}
		sortSentenceList(sentenses);
		TextComposite newRoot = new TextComposite();
		newRoot.add(new ParagraphComposite(sentenses));

		return newRoot;
	}

	private void sortSentenceList(List<SentenseComposite> sentenses) {
		CountLexemeVisitor vis = new CountLexemeVisitor();
		sentenses.sort((right, left) -> {
			right.accept(vis);
			int rightCount = vis.result();
			vis.reset();
			left.accept(vis);
			int leftCount = vis.result();
			vis.reset();
			return leftCount - rightCount;
		});
	}

	public TextComposite sortLexemeByAlphabet(TextComposite textRoot) throws UnacceptableArgument {
		List<WordComposite> words = new ArrayList<>();
		if (textRoot instanceof TextComposite) {
			textRoot.getChildrenList().forEach(par -> par.getChildrenList().forEach(
					sent -> sent.getChildrenAsSteam().filter((el) -> (el instanceof WordComposite)).forEach(w -> words.add((WordComposite) w))));
		} else {
			throw new UnacceptableArgument("Root is not a Text");
		}
		sortWordsByAlphabet(words);
		TextComposite newRoot = new TextComposite();
		char firstLetter = '\u0001';
		TextLeaf space = new TextLeaf(TextLeaf.NodeType.SPACE, ' ');
		SentenseComposite sameLetterWords = null;
		for (WordComposite word : words) {
			if (Character.toLowerCase(word.getChild(0).item()) == firstLetter) {
				sameLetterWords.add(space);
				sameLetterWords.add(word);
			} else {
				firstLetter = Character.toLowerCase(word.getChild(0).item());
				ParagraphComposite par = new ParagraphComposite();
				newRoot.add(par);
				sameLetterWords = new SentenseComposite();
				par.add(sameLetterWords);
				sameLetterWords.add(word);
			}
		}
		return newRoot;
	}

	private void sortWordsByAlphabet(List<WordComposite> words) {
		TextVisitor<String> textVisitor = new PrintTextVisitor();
		words.sort((right, left) -> {
			String r, l;
			right.accept(textVisitor);
			r = textVisitor.result();
			textVisitor.reset();
			left.accept(textVisitor);
			l = textVisitor.result();
			textVisitor.reset();
			return r.compareToIgnoreCase(l);
		});
	}
}
