package seedu.address.model.person;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.tag.Tag;

/**
 */
public class TagsContainKeywordsPredicate implements Predicate<ReadOnlyPerson>
{
    private final List<String> keywords;

    public TagsContainKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * @param setTags
     * @return
     */
    private String stringifySetTags(Set<Tag> setTags) {
        StringBuilder setTagsString = new StringBuilder();
        final String Delimiter = " ";

        Iterator<Tag> tagIterator = setTags.iterator();
        while (tagIterator.hasNext()) {
            Tag checkingTag = tagIterator.next();
            setTagsString.append(checkingTag.tagName);
            setTagsString.append(Delimiter);
        }

        return setTagsString.toString();
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(stringifySetTags(person.getTags()), keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagsContainKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((TagsContainKeywordsPredicate) other).keywords)); // state check
    }
}
